package br.com.dogkit.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.dogkit.common.bean.UsuarioBean;
import br.com.dogkit.persistence.dao.IUsuarioDao;

@Repository(value = "IUsuarioDao")
public class UsuarioDao implements IUsuarioDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String GET_USUARIOS = "SELECT * FROM tb_usuario";
	private static final String GET_USUARIO = "SELECT * FROM tb_usuario WHERE id = ?";
	private static final String POST_USUARIO = "INSERT INTO tb_usuario (nome_completo, email, telefone, sexo, data_criacao) VALUES (?, ?, ?, ?, ?)";

	@Override
	public List<UsuarioBean> getUsuarios() {

		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(GET_USUARIOS);
		List<UsuarioBean> usuarios = new ArrayList<>();

		for (Map<String, Object> map : queryForList) {
			UsuarioBean usuarioBean = new UsuarioBean();
			usuarioBean.setId(Long.valueOf(map.get("id").toString()));
			usuarioBean.setNomeCompleto(map.get("nome_completo").toString());
			usuarioBean.setEmail(map.get("email").toString());
			usuarioBean.setTelefone(map.get("telefone").toString());
			usuarioBean.setSexo(map.get("sexo").toString());
			usuarioBean.setDataCriacao((Date) map.get("data_criacao"));
			usuarioBean.setDataModificacao((Date) map.get("data_modificacao"));
			usuarios.add(usuarioBean);
		}

		return usuarios;
	}

	@Override
	public UsuarioBean getUsuario(Long id) {

		UsuarioBean usuarioBean = null;

		try {

			usuarioBean = jdbcTemplate.queryForObject(GET_USUARIO, new Object[] { id },

					new RowMapper<UsuarioBean>() {

						@Override
						public UsuarioBean mapRow(ResultSet rs, int rowNum) throws SQLException {
							UsuarioBean bean = new UsuarioBean();
							bean.setId(rs.getLong("id"));
							bean.setNomeCompleto(rs.getString("nome_completo"));
							bean.setEmail(rs.getString("email"));
							bean.setTelefone(rs.getString("telefone"));
							bean.setSexo(rs.getString("sexo"));
							bean.setDataCriacao(rs.getTimestamp("data_criacao"));
							bean.setDataModificacao(rs.getTimestamp("data_modificacao"));
							return bean;
						}

					});

		} catch (Exception e) {
			System.out.println("Usuário não encontrado!");
		}

		return usuarioBean;
	}

	@Override
	public void putUsuario(UsuarioBean usuarioBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUsuario(UsuarioBean usuarioBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postUsuario(UsuarioBean usuarioBean) {
		jdbcTemplate.update(POST_USUARIO, new Object[] { usuarioBean.getNomeCompleto(), usuarioBean.getEmail(),
				usuarioBean.getTelefone(), usuarioBean.getSexo(), new Date() });
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
