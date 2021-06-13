package me.luucx7.creativecore.v2.managers;

import me.luucx7.creativecore.v2.api.Quiz;
import me.luucx7.creativecore.v2.model.QuizImpl;
import org.bukkit.entity.Player;

public class QuizManager {

    private static Quiz quiz;

    public static Quiz getQuiz() {
        return quiz;
    }

    public static boolean quizHappeningNow() {
        if (quiz == null) return false;
        return quiz.isRunning();
    }

    public static Quiz newQuiz(Player starter) {
        Quiz newQuiz = new QuizImpl();

        quiz = newQuiz;
        return newQuiz;
    }

    public static void clearQuiz() {
        quiz = null;
    }
}
