package in.erai.batch.spring.batch.annotation;

import java.util.List;

public interface DaoInterface {

    Integer getUnitCountOfPerson(Person person);
    List<String> verifyIfFirstNameIsValid(Person person);
}
