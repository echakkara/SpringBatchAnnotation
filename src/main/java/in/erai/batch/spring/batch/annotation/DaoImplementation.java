package in.erai.batch.spring.batch.annotation;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("DaoInterface")
public class DaoImplementation extends Dao implements DaoInterface {

    @Override
    public Integer getUnitCountOfPerson(Person person) {
        //System.out.println("select count(first_name) from people where first_name = " + person.getFirstName());
        return getJdbcTemplate().queryForObject(
                "select count(first_name) from people where first_name = ?",
                new Object[] {person.getFirstName() }, Integer.class );

    }

    @Override
    public List<String> verifyIfFirstNameIsValid(final Person person) {
        System.out.println("select first_name from people where first_name = '" + person.getFirstName()
        + "' and last_name = '" + person.getLastName() +"'" );

        return getJdbcTemplate().query (
                "select first_name from people where first_name = ?  and last_name = ?",
                new Object [] {person.getFirstName(), person.getLastName()},
                (resultSet, rowNum) -> resultSet.getString("first_name")

        );

/*        List<String> unitIdList = getJdbcTemplate().query(
                "select first_name from people where first_name = ?  and last_name = ?",
                new PreparedStatementSetter() {
            @Override
            public void setValues(final PreparedStatement pStmt)
                    throws SQLException {
                pStmt.setString(1, person.getFirstName());
                pStmt.setString(2, person.getLastName());

            }
        }, new RowMapper<String>() {
            @Override
            public String mapRow(final ResultSet resultSet, final int rowNum)
                    throws SQLException {
                return resultSet.getString("first_name");
            }
        });*/


    }

}
