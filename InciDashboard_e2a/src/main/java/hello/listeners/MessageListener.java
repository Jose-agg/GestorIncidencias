package hello.listeners;

import javax.annotation.ManagedBean;

/**
 * Created by herminio on 28/12/16.
 */
@ManagedBean
public class MessageListener {
	/*
	@Autowired
	AgentService agentService;
	
	@Autowired
	CamposCriticosService ccService;

	private static final Logger logger = Logger.getLogger(MessageListener.class);

    @KafkaListener(topics = "newIncidence")
    public void listen(String data) {
        logger.info("New message received: \"" + data + "\"");
    }
    
    public void parseToIncidence(String data) {
    	//NombreUsuario@nombreIncidencia@descripcion@localizacion@etiquetas_#1
    	//@listaCampos_#3@estado@entidadAsignada@comentarioOperario@caducidad
    	
    	String[] camposSeparados=separaCampos(data);
    	Incidence incidence=new Incidence();
    	//agent
    	incidence.setAgent(agentService.findByName(camposSeparados[0]));
    	//nombreIncidencia
    	incidence.setNombre(camposSeparados[1]);
    	//descripcion
    	incidence.setDescripcion(camposSeparados[2]);
    	//localizacion
    	incidence.setLocalizacion(location(camposSeparados[3]));
    	//etiquetas
    	incidence.setEtiquetas(etiquetas(camposSeparados[4]));
    	//lista de campos
    	incidence.setCampos(listaCampos(camposSeparados[5]));
    	//estado
    	incidence.setEstado(Status.ABIERTO);
    	//comentario operario
    	incidence.setOperadorAsignado(null);
    	//caducidad falta el parseo a date
    	incidence.setCaducidad(parseFecha(camposSeparados[6]));
    	//id
    	incidence.setId(Long.parseLong(camposSeparados[7]));
    	
    	
    }
    
    private String[] separaCampos(String data) {
    	String[] aux = data.split("@");
    	return aux;
    }
    

    private Set<Etiqueta> etiquetas(String etiquetas){
    	HashSet<Etiqueta> set=new HashSet<Etiqueta>();
    	String[] aux = etiquetas.split("$");
    	for(String s:aux) {
    		Etiqueta etiqueta=new Etiqueta();
    		etiqueta.setValor(s);
    		set.add(etiqueta);
    	}
    	return set;
    }
    
    
    
    private Set<Campo> listaCampos(String campos){
    	HashSet<Campo> set=new HashSet<Campo>();
    	String[] aux = campos.split("$");
    	for(String s: aux) {
    		set.add(claveValor(s));
    	}
    	return set;
    }

	private Campo claveValor(String s) {
		Campo campo=new Campo();
		String[] aux = s.split(":");
		CamposCriticos cCritico = ccService.findByClave(aux[0]);
		//Esto habria que hacerlo bien pero hace falta 
		//saber primero como vienen exactamente el formato del valor de los campos
		if(cCritico.getValor().equals(aux[1])){
			campo.setClave(aux[0]);
			campo.setValor(aux[1]);
			campo.setTipo(TipoCampos.CRITICO);
		}
		else{
			campo.setClave(aux[0]);
			campo.setValor(aux[1]);
			campo.setTipo(TipoCampos.NO_CRITICO);
		}
		return campo;
		
	}
    
	public static Date parseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
	
	private Location location(String s) {
		Location loc=new Location();
		String[] aux = s.split("\\$");
		loc.setLatitud(Double.parseDouble(aux[0]));
		loc.setLongitud(Double.parseDouble(aux[1]));
		return loc;
		
		
	}
    
	*/
}
