package br.com.dogkit.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/get_usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioBean> getUsuario(@PathVariable("id") Long id) {
		UsuarioBean usuarioBean = usuarioDao.getUsuario(id);

		if (usuarioBean == null) {
			return new ResponseEntity<UsuarioBean>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UsuarioBean>(usuarioBean, HttpStatus.OK);
	}

	@RequestMapping(value = "/post_usuario", method = RequestMethod.POST)
	public ResponseEntity<Void> postUsuario(@RequestBody UsuarioBean usuarioBean) {
		usuarioDao.postUsuario(usuarioBean);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	public IUsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
