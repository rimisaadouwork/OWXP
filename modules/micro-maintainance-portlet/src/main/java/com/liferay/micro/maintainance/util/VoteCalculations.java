package com.liferay.micro.maintainance.util;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public class VoteCalculations {

	public static int getTotalVotes(String analysisData) {
		try {
			JSONObject jsonObject = _jsonFactory.createJSONObject(analysisData);

			int noVotes = jsonObject.getInt(VoteConstants.NO_DESCRIPTION);
			int yesVotes = jsonObject.getInt(VoteConstants.YES_DESCRIPTION);
			int notVoted = jsonObject.getInt(
				VoteConstants.NOT_VOTED_DESCRIPTION);

			return noVotes + yesVotes + notVoted;
		}
		catch (JSONException jsone) {
		}

		return 0;
	}

	public static int getVoteCount(String analysisData, String voteConstants) {
		try {
			JSONObject jsonObject = _jsonFactory.createJSONObject(analysisData);

			return jsonObject.getInt(voteConstants);
		}
		catch (JSONException jsone) {
		}

		return 0;
	}

	public static double getVotePercentage(
		String analysisData, String voteConstants) {

		int total = getTotalVotes(analysisData);
		int noVotes = getVoteCount(analysisData, voteConstants);

		return _calculatePercentage(total, noVotes);
	}

	public static String toReadableFormat(String analysisData)
		throws JSONException {

		int total = getTotalVotes(analysisData);
		int noVotes = getVoteCount(analysisData, VoteConstants.NO_DESCRIPTION);
		int yesVotes = getVoteCount(
			analysisData, VoteConstants.YES_DESCRIPTION);
		int notVoted = getVoteCount(
			analysisData, VoteConstants.NOT_VOTED_DESCRIPTION);

		return String.format(
			"%d (%.2f %%) voted '%s' \n %d (%.2f %%) voted '%s' \n" +
				"%d (%.2f %%) did not vote \n",
			noVotes, _calculatePercentage(total, noVotes),
			VoteConstants.NO_DESCRIPTION, yesVotes,
			_calculatePercentage(total, yesVotes),
			VoteConstants.YES_DESCRIPTION, notVoted,
			_calculatePercentage(total, notVoted));
	}

	private static double _calculatePercentage(int total, int score) {
		if ((total <= 0) || (score <= 0)) {
			return 0.00;
		}

		return score * 100 / total;
	}

	private static JSONFactory _jsonFactory;

}