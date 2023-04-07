package rpg.domain.monster;

import rpg.domain.attack.Attack;
import rpg.domain.attack.AttackType;
import rpg.domain.skill.InvalidSkillTypeException;
import rpg.domain.skill.Skill;

public class Dragon extends Monster {

    public Dragon(int health, int strength, int dexterity, int intelligence, int experience, int level, String name) {
        super(health, strength, dexterity, intelligence, experience, level, name);
    }

    public static Dragon generateDragon() {
        return new Dragon(
                10000,
                100,
                100,
                150,
                10000,
                1,
                "Dragon"
        );
    }

    @Override
    public Attack attack() {

        return new Attack(
                "Griffe",
                AttackType.MELEE,
                10 + 2 * level + strength * 2,
                2.5f
        );
    }

    /**
     * @return damage took
     */
    @Override
    public int defend(Attack attack) {
        int damageCalculated = 0;

        this.takeDamage(damageCalculated);

        return damageCalculated;

    }

    @Override
    public void defend(Skill skill) {
        switch (skill.getType()) {
            case DEXTERITY_INCREASE:
            case INTELLIGENCE_INCREASE:
            case STRENGTH_INCREASE:
            case DAMAGE:

            case DEXTERITY_DECREASE:
            case INTELLIGENCE_DECREASE:
            case STRENGTH_DECREASE:
                break;

            case HEAL:
                this.health = (skill.getAmount());
                break;

            default:
                throw new InvalidSkillTypeException();
        }
    }
}
