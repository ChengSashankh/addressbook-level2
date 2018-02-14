package seedu.addressbook.commands;

import seedu.addressbook.common.PersonNameComparator;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Lists all persons in the address book to the user in sorted order.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book in sorted order as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> sortedPersons = new ArrayList<>(allPersons);
        Collections.sort(sortedPersons, new PersonNameComparator());
        return new CommandResult(getMessageForPersonListShownSummary(sortedPersons), sortedPersons);
    }
}
