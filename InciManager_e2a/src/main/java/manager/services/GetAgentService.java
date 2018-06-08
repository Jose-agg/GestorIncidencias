package manager.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manager.entities.Agent;
import manager.repository.AgentsRepository;

@Service
public class GetAgentService {

	@Autowired
	private AgentsRepository agentsRepository;

	public Agent findAgent(String usuario, String password, String kind) throws Exception {
		return callAgent(usuario, password, kind);
	}

	private Agent callAgent(String usuario, String password, String kind) throws Exception {
		URL url = new URL("http://35.180.109.178:8070/info");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/json");

		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write("{\"login\":\"" + usuario + "\", \"password\":\"" + password + "\", \"kind\":\"" + kind + "\"}");
		out.flush();
		out.close();

		Agent a = recogeRespuesta(connection);
		connection.disconnect();
		return a;
	}

	private Agent recogeRespuesta(HttpURLConnection connection) throws IOException {
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		Agent a = null;
		while ((line = br.readLine()) != null) {
			JSONObject obj = new JSONObject(line);
			if (obj.has("id")) {
				a = generaAgente(obj);
				return a;
			}
		}
		return null;
	}

	private Agent generaAgente(JSONObject obj) {
		Agent a = new Agent(obj.getLong("id"), obj.getString("password"), obj.getString("kind"),
				obj.getLong("kindCode"), obj.getString("dni"), obj.getString("nombre"), obj.getString("apellidos"),
				obj.getString("email"), obj.getString("username"));
		System.err.println(a);
		return a;
	}

	public Agent buscarAgentePorUsuario(String username) {
		return agentsRepository.findAgentByUsername(username);
	}

	public void addAgent(Agent agent) {
		agentsRepository.save(agent);
	}

	public void elimnarAgent(Long id) {
		agentsRepository.delete(id);
	}
}