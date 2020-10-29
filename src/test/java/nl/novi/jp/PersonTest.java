package nl.novi.jp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * De PersonTest klasse. We noemen Testklasse altijd hetzelfde als de klasse die we gaan testen, maar we zetten wel het
 * woordje Test erachter.
 *
 * Deze klasse staat op precies dezelfde plek in de packagestructuur. Zowel Person.java als PersonTest.java staan in
 * package nl.novi.jp; PersonTest.java staat echter in src/test/java en Person.java in src/main/java
 */
public class PersonTest {

    @Test
    public void nameShouldNotBeChangedDuringCreation() {
        Person person = new Person("Nick");
        assertEquals("Nick", person.getName());
    }

    @Test
    public void personWithoutNameShouldBeNamedJohn() {
        Person person = new Person();
        assertEquals("John", person.getName());
    }

    @Test
    public void ageShouldAddOneYear() {
        Person person = new Person("Nick");
        person.setAge(30);
        person.age();
        assertEquals(31, person.getAge());
    }

    @Test
    public void lastNameShouldStartWithUpperCaseWhenLowercaseGiven() {
        Person person = new Person("Sjaak");
        person.setLastName("polak");
        assertEquals("Polak", person.getLastName());
    }

    @Test
    public void lastNameShouldStartWithUppercase() {
        Person person = new Person("Harry");
        person.setLastName("Bonus");
        assertEquals("Bonus", person.getLastName());
    }

    //Voorbeeld met boolean check. AssertFalse
    @Test
    public void givenNoPartnerHasPartnerShouldReturnFalse() {
        Person foreverAlone = new Person();
        assertFalse(foreverAlone.hasPartner());
    }

    @Test
    public void givenAPartnerHasPartnerShouldReturnTrue() {
        Person happilyMarried = new Person();
        Person unhappilyMarried = new Person();
        happilyMarried.setPartner(unhappilyMarried);
        unhappilyMarried.setPartner(happilyMarried);
        assertTrue(happilyMarried.hasPartner());
        assertTrue(unhappilyMarried.hasPartner());
    }

    // Voorbeeld met een ArrayList. Hoe kan je testen dat dat goed gaat?
    @Test
    public void childShouldBeAddedToList() {
        Person person = new Person();
        Person child = new Person();
        person.addChild(child);
        //  Technically not Clean Code
        assertEquals(1, person.getChildren().size());
        assertEquals(child.getName(), person.getChildren().get(0).getName());
    }

    @Test
    public void childWithNonUniqueNameCannotBeAddedToList() {
        Person person = new Person();
        Person child = new Person();
        Person duplicateChild = new Person();
        person.addChild(child);
        person.addChild(duplicateChild);
        assertEquals(1, person.getChildren().size());
    }

    // Third case is not tested!
}
