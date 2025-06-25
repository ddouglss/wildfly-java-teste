package dao;

import model.Pessoa;
import util.ConnectionFactory;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    public void salvar(Pessoa pessoa) throws Exception {
    	String sql = "INSERT INTO pessoa (nome, idade) VALUES (?, ?)";
        try (Connection con = ConnectionFactory.getConnection(); //erro
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.executeUpdate();
        }
    }
    
    public Pessoa buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Pessoa p = new Pessoa();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setIdade(rs.getInt("idade"));
                    return p;
                }
            }
        }
        return null;
    }
    
    public void atualizar(Pessoa pessoa) throws Exception {
        String sql = "UPDATE pessoa SET nome = ?, idade = ? WHERE id = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setInt(3, pessoa.getId());
            stmt.executeUpdate();
        }
    }


    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Pessoa> listar() throws Exception {
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        try (Connection con = ConnectionFactory.getConnection();//erro
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                lista.add(p);
            }
        }
        return lista;
    }
}
