package rpg.domain.persona.job;

import rpg.domain.attack.Attack;
import rpg.domain.attack.AttackType;
import rpg.domain.persona.Persona;
import rpg.domain.skill.InvalidSkillTypeException;
import rpg.domain.skill.Skill;

public class Warlock extends Persona {
    public static final String JOB_NAME = "Warlock";
    private static final int HEALTH = 45;
    private static final int STRENGTH = 2 ;
    private static final int DEXTERITY = 2 ;
    private static final int INTELLIGENCE = 10;

    public Warlock(String name) {
        super(name, HEALTH, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    public Attack attack() {
        return new Attack(
                "Feu impur",
                AttackType.MAGIC,
                10 + 2 * getLevel() + this.getIntelligence() * 4
        );
    }

    public int defend(Attack attack) {
        int damageCalculated = 0;
        switch (attack.getType()) {
            case MELEE:
                damageCalculated = attack.getDamage() - this.getStrength() / 2;
                break;
            case RANGED:
                damageCalculated = attack.getDamage() - this.getDexterity() / 2;
                break;
            case MAGIC:
                damageCalculated = attack.getDamage() - (this.getIntelligence() * 3);
                break;
        }
        this.takeDamage(damageCalculated);

        return damageCalculated;
    }

    public void defend(Skill skill) {
        switch (skill.getType()) {
            case DEXTERITY_INCREASE:
                this.increaseDexterity(skill.getAmount());
                break;
            case INTELLIGENCE_INCREASE:
                this.increaseIntelligence(skill.getAmount() * 3);
                break;
            case STRENGTH_INCREASE:
                this.increaseStrength(skill.getAmount());
                break;

            case HEAL:
                this.heal(skill.getAmount());
                break;
            case DAMAGE:
                this.takeDamage(skill.getAmount());
                break;

            case DEXTERITY_DECREASE:
                this.decreaseDexterity(skill.getAmount());
                break;
            case STRENGTH_DECREASE:
                this.decreaseStrength(skill.getAmount());
                break;
            case INTELLIGENCE_DECREASE:
                this.decreaseIntelligence(skill.getAmount());
                break;
            default:
                throw new InvalidSkillTypeException();
        }
    }


    @Override
    protected void levelUpStats() {
        this.baseDexterity +=  2 * this.getLevel();
        this.baseIntelligence += 4 * this.getLevel();
        this.baseStrength  += 1 * this.getLevel();;
    }

    @Override
    public String jobName() {
        return JOB_NAME;
    }
}
