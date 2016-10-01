package ru.reeson2003.chars;

import ru.reeson2003.items.Gold;
import ru.reeson2003.map.Direction;
import ru.reeson2003.map.Interactable;
import ru.reeson2003.map.Position;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Rabbit extends Creature {
    public Rabbit(String name, Position position) {
        super(name, "Кролик", position);
    }

    @Override
    public String getInfo() {
        String result = new String(info + " по имени " + name);
        return result;
    }

    @Override
    public List<Interactable> interact(Player player) {
        player.getGold().addGold(new Gold(1));

        if (position.move(Direction.South) == position &&
                position.move(Direction.East) == position &&
                position.move(Direction.North) == position &&
                position.move(Direction.West) == position) {
            List<Interactable> result = new LinkedList<>();
            result.add(this);
            return result;
        } else {
            if (position.move(Direction.South) != position) {
                position.moveItem(this, position.move(Direction.South));
                position = position.move(Direction.South);
            }
            else if (position.move(Direction.East) != position) {
                position.moveItem(this, position.move(Direction.East));
                position = position.move(Direction.East);
            }
            else if (position.move(Direction.North) != position) {
                position.moveItem(this, position.move(Direction.North));
                position = position.move(Direction.North);
            }
            else if (position.move(Direction.West) != position) {
                position.moveItem(this, position.move(Direction.West));
                position = position.move(Direction.West);
            }
            return null;
        }
    }
}
