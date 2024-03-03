package Seminar_05.CharacterPackage;

import java.util.ArrayList;

public abstract class BaseWizard extends BaseCharacter{
    private int mana;
    private int maxMana = 100;
    private int manaToHeal = 10;
    private int manaToRevive = 100;

    private int healedHP = 10;
    private int HPAfterRev = 20;
    private int minDyingFriendToRev = 3;
    private int recManaByStep = 10;

    private int expForHeal = 10;
    private int expForRev = 20;
    private int expForStand = 5;

    protected BaseWizard(String name, String weapon, int x, int y, Team teamSide) {
        super(name, weapon, 5, 3, x, y, 1, teamSide);
        this.mana = 100;
    }
    
    @Override
    public void GetXp(int xp) {
        if (current_xp + xp >= xpInLevel) {
            level++;
            current_xp += xp - xpInLevel;
            manaToHeal = (manaToHeal - 1) < 5 ? 5 : manaToHeal - 1;
            healedHP += 5;
            HPAfterRev += 5;
            if (level % 5 == 0 && level < 11) minDyingFriendToRev--;
            recManaByStep = (recManaByStep + 1) > 15 ? 15 : recManaByStep + 1;
            System.out.println("повысил уровень!");
        } else {
            current_xp += xp;
        }
    }

    public void heal(BaseCharacter friend) {
        friend.healed(healedHP);
        mana -= manaToHeal;
        System.out.println("вылечил " + friend.getInfo() + " " + friend.getName());
        lastAct = "вылечил товарища!";
    }

    public void revive(BaseCharacter friend) {
        friend.revival(HPAfterRev);
        mana -= manaToRevive;
        System.out.println("возродил " + friend.getInfo() + " " + friend.getName());
        lastAct = "возродил братишку!";
    }
    
    public void recMana(int mana) {
        if (this.mana + mana >= this.maxMana) {
            this.mana = this.maxMana;
        } else {
            this.mana += mana;
        }
        lastAct = "пополнил ману!";
    }

    @Override
    public void step(ArrayList<BaseCharacter> AllUnits) {
        if (isAlive) {
            if (getCountDyingFriends(AllUnits) >= minDyingFriendToRev && mana >= manaToRevive) {
                revive(getRandomDeceasedFriend(AllUnits));
                GetXp(expForRev);
            } else if (mana >= manaToHeal) {
                heal(getFriendWithMinHealth(AllUnits));
                GetXp(expForHeal);
            } else {
                recMana(recManaByStep);
                GetXp(expForStand);
            }
        }
    }
}
