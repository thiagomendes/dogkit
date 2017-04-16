package br.com.dogkit.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dogkit.common.bean.UsuarioBean;
import br.com.dogkit.persistence.dao.IUsuarioDao;

@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioDao usuarioDao;

	@RequestMapping(value = "/get_usuarios", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioBean>> getUsuarios() {
		return new ResponseEntity<List<UsuarioBean>>(usuarioDao.getUsuarios(), HttpStatus.OK);
	}

	public IUsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
