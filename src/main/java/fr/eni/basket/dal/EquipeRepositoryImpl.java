package fr.eni.basket.dal;

import fr.eni.basket.bo.Equipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EquipeRepositoryImpl implements EquipeRepository {
    private JdbcTemplate jdbcTemplate;

    public EquipeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class EquipeRowMapper implements RowMapper<Equipe> {

        @Override
        public Equipe mapRow(ResultSet rs, int rowNum) throws SQLException {
            Equipe equipe = new Equipe();
            equipe.setNoEquipe(rs.getInt("noEquipe"));
            equipe.setNom(rs.getString("nom"));
            return equipe;
        }
    }

    @Override
    public List<Equipe> findAllEquipes() {
        String sql = "select noEquipe, nom  from equipes";

        List<Equipe> equipes = jdbcTemplate.query(sql, new EquipeRowMapper());

        return equipes;
    }
}
