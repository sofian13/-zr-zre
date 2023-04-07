package rpg.domain.persona;

import rpg.domain.persona.job.Mage;
import rpg.domain.persona.job.Priest;
import rpg.domain.persona.job.Ranger;
import rpg.domain.persona.job.Warrior;
import rpg.domain.persona.job.Warlock;

/**
 * A factory for creating Personas.
 */
public class PersonaFactory {
    /**
     * Creates a new Persona with job & level expected.
     *
     * @param name       the name of the persona
     * @param personaJob the job expected
     * @param level      the level expected
     * @return the persona
     */
    public static Persona createPersona(String name, String personaJob, int level) {
        switch (personaJob) {
            case Warrior.JOB_NAME:
                return createWarrior(name, level);
            case Ranger.JOB_NAME:
                return createRanger(name, level);
            case Mage.JOB_NAME:
                return createMage(name, level);
            case Priest.JOB_NAME:
                return createPriest(name, level);
            case Warlock.JOB_NAME:
                return createWarlock(name, level);

            default:
                throw new UnknownPersonaJobException(personaJob);
        }
    }

    private static Warlock createWarlock(String name, int level) {
        Warlock warlock = new Warlock(name);

        gainExperience(warlock, level);

        return warlock;
    }

    private static Warrior createWarrior(String name, int level) {
        Warrior warrior = new Warrior(name);

        gainExperience(warrior, level);

        return warrior;
    }

    private static Ranger createRanger(String name, int level) {
        Ranger ranger = new Ranger(name);

        gainExperience(ranger, level);

        return ranger;
    }

    private static Mage createMage(String name, int level) {
        Mage mage = new Mage(name);

        gainExperience(mage, level);

        return mage;
    }

    private static Priest createPriest(String name, int level) {
        Priest priest = new Priest(name);

        gainExperience(priest, level);

        return priest;
    }

    private static void gainExperience(Persona persona, int levelExpected) {
        while (persona.getLevel() < levelExpected) {
            persona.gainExperience(1);
        }
    }
}
