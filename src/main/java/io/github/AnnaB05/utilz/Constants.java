package io.github.AnnaB05.utilz;

public class Constants {
    public static class PlayerConstants{
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMPING = 2;
        public static final int DOUBLE_JUMPING = 3;
        public static final int WALL_JUMPING = 4;
        public static final int FALLING = 5;
        public static final int ATTACK = 6;

        public static int GetSpriteAmount(int player_action) {
            switch(player_action) {
                case IDLE:
                    return 10;
                case RUNNING:
                    return 12;
                case DOUBLE_JUMPING:
                    return 6;
                case WALL_JUMPING:
                    return 5;
                case JUMPING:
                case FALLING:
                    return 1;
                case ATTACK:
                    return 7;
                default:
                    return 1;
            }
        }

    }
}
