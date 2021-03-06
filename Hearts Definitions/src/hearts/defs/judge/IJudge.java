package hearts.defs.judge;

import hearts.defs.state.IGameState;
import hearts.defs.state.GameStateException;
import hearts.defs.actions.AAction;

/**
 * Klasa decydująca o tym, czy podaną akcję na podanym stanie gry można wykonać
 *
 * @author szymon
 */




public interface IJudge {
    
    /**
     * <p>Dostaje stan gry i akcję, na podstawie typu akcji ocenia, czy akcja
     * jest w tym momencie dozwolona i wywołuje na akcji perform()
     * z kopią stanu gry.</p>
     *
     * <p>Chatem zajmuje się StateGuard</p>
     *
     * <p>Potem sam podejmuje ew. własne czynności i dodaje swoje komunikaty do kolejki
     * w stanie gry przez state.addAction();</p>
     *
     * @param state aktualny stan gry
     * @param action akcja do rozpatrzenia
     * @return nowy stan gry
     * @throws GameStateException jeśli akcja nie jest dozwolona albo nie wie
     * co z nią zrobić.
     */
    public IGameState judge(IGameState state, AAction action) throws GameStateException;
}
