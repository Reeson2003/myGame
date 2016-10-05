package ru.reeson2003.npcs;

import ru.reeson2003.map.Direction;
import ru.reeson2003.Game.Interactable;
import ru.reeson2003.map.Position;
import ru.reeson2003.player.Player;

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
    public String getName() {
        return null;
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

            if (position.getByDirection(Direction.South) == position &&
                    position.getByDirection(Direction.East) == position &&
                    position.getByDirection(Direction.North) == position &&
                    position.getByDirection(Direction.West) == position) {
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
                if (position.getByDirection(direction) != position) {
                    position.moveObject(this, position.getByDirection(direction));
                    position = position.getByDirection(direction);
                } else if (position.getByDirection(direction) != position) {
                    position.moveObject(this, position.getByDirection(direction));
                    position = position.getByDirection(direction);
                } else if (position.getByDirection(direction) != position) {
                    position.moveObject(this, position.getByDirection(direction));
                    position = position.getByDirection(direction);
                } else if (position.getByDirection(direction) != position) {
                    position.moveObject(this, position.getByDirection(direction));
                    position = position.getByDirection(direction);
                }
                List<Interactable> result = new LinkedList<>();
                return result;
            }
        } else
            throw new IllegalArgumentException("No method for this item: " + something);
    }
}
