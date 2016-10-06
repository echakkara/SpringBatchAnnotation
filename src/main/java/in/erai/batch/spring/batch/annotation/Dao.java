package in.erai.batch.spring.batch.annotation;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class Dao {
    @Autowired
    public DataSource dataSource;

    protected final JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

}
