package asw.streamKafka.consumidor;


import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import asw.controllers.DashboardAdminController;
import asw.streamKafka.Topics;
import asw.streamKafka.parser.ParserIncidencia;


@ManagedBean
public class KafkaConsumer {

	@Autowired
	DashboardAdminController dsController;
	
	@Autowired
	ParserIncidencia parserInci;
	/**
	 * Este metodo es el listener de kafka que saltara cada vez que 
	 * llegue un incidencia por kafka
	 * Este metodo llamara a parseIncidence y esta quedara guardada
	 * en la base de datos
	 * @param incidencia en json
	 */
    @KafkaListener(topics = Topics.incidencias)
    public void listen(String data) {
    	System.out.println(data);
    	
       	String incidencia = parserInci.parseToIncidence( data );
      
        SseEventBuilder evento = SseEmitter.event().name((Topics.incidencias)).data( incidencia );
        this.dsController.sendData(evento);
      
    }
}
