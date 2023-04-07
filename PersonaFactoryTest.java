package rpg.domain.persona;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PersonaFactoryTest {

    @Test
    public void testCreatePersonaWarriorWithLevel1() {
        Persona persona = PersonaFactory.createPersona(
                "Warrior",
                "Warrior",
                1
        );
        assertEquals("Warrior", persona.getName());
        assertEquals(1, persona.getLevel());
        assertEquals("Warrior", persona.jobName());
    }

    @Test
    public void testCreatePersonaWarriorWithLevel9() {
        Persona persona = PersonaFactory.createPersona(
                "Warrior",
                "Warrior",
                9
        );
        assertEquals("Warrior", persona.getName());
        assertEquals(9, persona.getLevel());
        assertEquals("Warrior", persona.jobName());
    }

    @Test
    public void testCreatePersonaRangerWithLevel10() {
        Persona persona = PersonaFactory.createPersona(
                "Orlando Bloom",
                "Ranger",
                10
        );
        assertEquals("Orlando Bloom", persona.getName());
        assertEquals(10, persona.getLevel());
        assertEquals("Ranger", persona.jobName());
    }

    @Test
    public void testCreatePersonaWarlockWithLevel10() {
        Persona persona = PersonaFactory.createPersona(
                "Gul'dan",
                "Warlock",
                10
        );
        assertEquals("Gul'dan", persona.getName());
        assertEquals(10, persona.getLevel());
        assertEquals("Warlock", persona.jobName());
    }

    @Test
    public void testCreatePersonaMageWithLevel10() {
        Persona persona = PersonaFactory.createPersona(
                "Gandalf",
                "Mage",
                10
        );
        assertEquals("Gandalf", persona.getName());
        assertEquals(10, persona.getLevel());
        assertEquals("Mage", persona.jobName());
    }

    @Test
    public void testCreatePersonaPriestWithLevel10() {
        Persona persona = PersonaFactory.createPersona(
                "Sparadrap",
                "Priest",
                10
        );
        assertEquals("Sparadrap", persona.getName());
        assertEquals(10, persona.getLevel());
        assertEquals("Priest", persona.jobName());
    }

    @Test
    public void testTryToCreatePersonWithUnknownJob() {
        try {
            PersonaFactory.createPersona(
                    "Warrior",
                    "Unknown",
                    1
            );
            fail("Should throw exception");
        } catch (UnknownPersonaJobException e) {
            assertEquals("Unknown persona job: Unknown", e.getMessage());
        }
    }
}