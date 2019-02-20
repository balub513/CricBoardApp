package com.example.balakrishnaballi.cricboardapp.mvp.view;

import com.example.balakrishnaballi.cricboardapp.mvp.model.Match;
import com.example.balakrishnaballi.cricboardapp.mvp.model.OldMatches;
import com.example.balakrishnaballi.cricboardapp.mvp.model.ScoreCard;
import com.example.balakrishnaballi.cricboardapp.mvp.model.room.User;

import java.util.List;

public interface view {

    interface SignupView {
        void registraionSuccessful();

        void errorInRegistraion();
    }

    interface LoginView {
        void loginSuccess();

        void loginFail();
    }

    interface UsersListView {
        void sendBackusersList(List<User> userList);

        void sendError(String err);

        void addUserSuccessful();

        void addUserFailure();
    }

    interface UpcomingMatchesView {

        void sendBackUpcomingMathces(List<Match> upcomingMatches);

        void sendErrorReport(String errorMessage);
    }

    interface OldMatchesView {

        void sendBackOldMathces(List<OldMatches.MatchSummary> listMatchSummaries);

        void sendbackErrorResponse(String errorMsg);

    }

    interface ScorecardView {
        void senBackScoreCard(ScoreCard scoreCard);

        void sendbackErrorResponse(String errorMsg);
    }
}
