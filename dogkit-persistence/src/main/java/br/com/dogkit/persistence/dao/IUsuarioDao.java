package br.com.dogkit.persistence.dao;

import java.util.List;

import br.com.dogkit.common.bean.UsuarioBean;

public interface IUsuarioDao {

	public List<UsuarioBean> getUsuarios();

	public UsuarioBean getUsuario(Long id);

	public void putUsuario(UsuarioBean usuarioBean);

	public void deleteUsuario(UsuarioBean usuarioBean);

	public void postUsuario(UsuarioBean usuarioBean);

}
