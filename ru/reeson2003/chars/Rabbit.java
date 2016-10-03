package ru.reeson2003.chars;

import ru.reeson2003.items.Gold;
import ru.reeson2003.map.Direction;
import ru.reeson2003.map.Interactable;
import ru.reeson2003.map.Position;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
    public List<Interactable> interact(Interactable something) {
        if (something instanceof Player) {
            Player player = (Player) something;

            if (position.move(Direction.South) == position &&
                    position.move(Direction.East) == position &&
                    position.move(Direction.North) == position &&
                    position.move(Direction.West) == position) {
                List<Interactable> result = new LinkedList<>();
                result.add(this);
                return result;
            } else {
                Random random = new Random();
                int dir = random.nextInt(4);
                Direction direction = Direction.Here;
                if (dir == 0)
                    direction = Direction.South;
                else if (dir == 1)
                    direction = Direction.East;
                else if (dir == 2)
                    direction = Direction.North;
                else if (dir == 3)
                    direction = Direction.West;

                Position p = position;
                if (position.move(direction) != position) {
                    position.moveItem(this, position.move(direction));
                    position = position.move(direction);
                } else if (position.move(direction) != position) {
                    position.moveItem(this, position.move(direction));
                    position = position.move(direction);
                } else if (position.move(direction) != position) {
                    position.moveItem(this, position.move(direction));
                    position = position.move(direction);
                } else if (position.move(direction) != position) {
                    position.moveItem(this, position.move(direction));
                    position = position.move(direction);
                }
                List<Interactable> result = new LinkedList<>();
                result.add(new Gold((random.nextInt(5) + 1),p));
                return result;
            }
        } else
            throw new IllegalArgumentException("No method for this item: " + something);
    }
}
