package in.erai.batch.spring.batch.annotation;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {


    @Autowired
    DaoInterface daoInterface;

    @Override
    public Person process(final Person person) throws Exception {



        System.out.println("Person COunt:: " + daoInterface.getUnitCountOfPerson(person));
        List<String> personList;
        personList = daoInterface.verifyIfFirstNameIsValid(person);
        System.out.println("Person List :: " + personList.toString());
        return person;
    }

}
