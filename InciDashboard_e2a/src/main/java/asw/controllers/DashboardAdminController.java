package asw.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import asw.Application;

@Controller
public class DashboardAdminController {

	private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());
	
	public void sendData(SseEventBuilder event) {
		synchronized (this.sseEmitters) {
			for (SseEmitter sseEmitter : this.sseEmitters) {
				try {
					sseEmitter.send(event);
				} catch (IOException e) {
					sseEmitter = new SseEmitter(Long.MAX_VALUE);
					Application.logger.error("Se ha cerrado el stream actual");
				}
			}
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8090") // manda respuesta a esta URL
	@RequestMapping("/getEmitter")
	public SseEmitter getEmitter() {
		return newEmitter();
	}

	public SseEmitter newEmitter() {
		
		SseEmitter emitter = new SseEmitter(Long.MAX_VALUE); // el timeout
		this.sseEmitters.add(emitter);
		
		emitter.onCompletion(() -> this.sseEmitters.remove(emitter));
		emitter.onTimeout(() -> this.sseEmitters.remove(emitter));
		
		return emitter;
	}

	public List<SseEmitter> getSseEmitters() {
		return sseEmitters;
	}
	
}


