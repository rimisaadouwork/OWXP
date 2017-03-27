package com.liferay.micro.maintainance.util;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public class VotesJSONSerializer {

	public static String createVotes() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("no", 0);
		jsonObject.put("not_voted", 0);
		jsonObject.put("yes", 0);

		return jsonObject.toString();
	}

	public static String updateVotes(
			String analysisData, int previousVote, int vote)
		throws JSONException {

		JSONObject jsonObject = _jsonFactory.createJSONObject(analysisData);

		if (previousVote == VoteConstants.NO) {
			_decreaseVote(jsonObject, "no");
		}
		else if (previousVote == VoteConstants.YES) {
			_decreaseVote(jsonObject, "yes");
		}
		else if (previousVote == VoteConstants.NOT_VOTED) {
			_decreaseVote(jsonObject, "not_voted");
		}

		if (vote == VoteConstants.NO) {
			_increaseVote(jsonObject, "no");
		}
		else if (vote == VoteConstants.YES) {
			_increaseVote(jsonObject, "yes");
		}
		else if (vote == VoteConstants.NOT_VOTED) {
			_increaseVote(jsonObject, "not_voted");
		}

		return jsonObject.toString();
	}

	private static void _decreaseVote(JSONObject jsonObject, String vote) {
		int votes = jsonObject.getInt(vote);

		jsonObject.put(vote, --votes);
	}

	private static void _increaseVote(JSONObject jsonObject, String vote) {
		int votes = jsonObject.getInt(vote);

		jsonObject.put(vote, ++votes);
	}

	private static JSONFactory _jsonFactory;

}