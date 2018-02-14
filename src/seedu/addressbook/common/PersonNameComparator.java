package seedu.addressbook.common;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<ReadOnlyPerson>{
    public int compare(ReadOnlyPerson person1, ReadOnlyPerson person2){
        return person1.getName().toString().compareTo(person2.getName().toString());
    }
}
