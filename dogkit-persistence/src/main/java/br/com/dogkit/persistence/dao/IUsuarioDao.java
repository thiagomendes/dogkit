package br.com.dogkit.persistence.dao;

import java.util.List;

import br.com.dogkit.common.bean.UsuarioBean;

public interface IUsuarioDao {

	public List<UsuarioBean> getUsuarios();

	public UsuarioBean getUsuario(Long id);

	public Integer putUsuario(UsuarioBean usuarioBean);

	public Integer deleteUsuario(UsuarioBean usuarioBean);

	public Integer postUsuario(UsuarioBean usuarioBean);

}
