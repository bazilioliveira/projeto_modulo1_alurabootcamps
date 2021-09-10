package br.com.alura.livraria.dao;

import br.com.alura.livraria.modelo.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {

    private Connection conexao;

    public AutorDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrar(Autor autor) {
        try {
            String sql = "INSERT INTO autores(nome, email, nascimento, curriculo) VALUES (?,?,?,?)";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, autor.getNome());
            ps.setString(2, autor.getEmail());
            ps.setDate(3, Date.valueOf(autor.getNascimento()));
            ps.setString(4, autor.getCurriculo());


            ps.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao MySQL!");
        }
    }

    public List<Autor> listar() {
        try {

            String sql = "SELECT * FROM autores";

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Autor> autores = new ArrayList<>();

            while (rs.next()) {

                Autor a = new Autor();

                a.setNome(rs.getString("nome"));
                a.setEmail(rs.getString("email"));
                a.setNascimento(rs.getDate("nascimento").toLocalDate());
                a.setCurriculo(rs.getString("curriculo"));

                autores.add(a);
            }

            return autores;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
