package uml;

public class CompositionBuilding {
    Room createAnonymousRoom() {
        return new Room() {
            @Override
            public void doInRoom() {}
        };
    }

    Room createInlineRoom() {
        class InlineRoom implements Room {
            @Override
            public void doInRoom() {}
        }
        return new InlineRoom();
    }

    Room createLambdaRoom() {
        return () -> {};
    }

    interface Room {
        void doInRoom();
    }
}