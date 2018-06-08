package es.uniovi.asw.business.impl;

import es.uniovi.asw.model.exception.*;

public interface Command {
	Object execute() throws BusinessException;
}
