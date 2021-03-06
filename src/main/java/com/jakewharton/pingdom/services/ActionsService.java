package com.jakewharton.pingdom.services;

import java.util.Date;
import java.util.List;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.pingdom.PingdomApiBuilder;
import com.jakewharton.pingdom.PingdomApiService;
import com.jakewharton.pingdom.entities.Actions;
import com.jakewharton.pingdom.enumerations.AlertStatus;
import com.jakewharton.pingdom.enumerations.AlertVia;

/**
 * Represents Pingdom's remote actions service.
 */
public final class ActionsService extends PingdomApiService {
	/**
	 * Get actions (alerts) that have been generated for your account.
	 * 
	 * @return Builder instance.
	 * @since 2.0
	 */
	public final GetBuilder get() {
		return new GetBuilder(this);
	}
	
	/**
	 * Request builder for {@link ActionsService#get()}.
	 */
	public static final class GetBuilder extends PingdomApiBuilder<Actions> {
		private static final String PARAM_FROM = "from";
		private static final String PARAM_TO = "to";
		private static final String PARAM_LIMIT = "limit";
		private static final String PARAM_OFFSET = "offset";
		private static final String PARAM_CHECK_IDS = "checkids";
		private static final String PARAM_CONTACT_IDS = "contactids";
		private static final String PARAM_STATUS = "status";
		private static final String PARAM_VIA = "via";
		
		private static final String URI = "/actions";
		
		private GetBuilder(PingdomApiService service) {
			super(service, new TypeToken<Actions>() {}, URI);
		}
		
		@Override
		protected JsonElement execute() {
			return super.execute().getAsJsonObject().get("actions").getAsJsonObject();
		}
		
		/**
		 * Only include actions generated later than this timestamp. (Optional)
		 * 
		 * @param from Starting timestamp.
		 * @return Builder instance.
		 */
		public GetBuilder from(Date from) {
			this.parameter(PARAM_FROM, from);
			return this;
		}
		
		/**
		 * Only include actions generated prior to this timestamp. (Optional)
		 * 
		 * @param to Ending timestamp.
		 * @return Builder instance.
		 */
		public GetBuilder to(Date to) {
			this.parameter(PARAM_TO, to);
			return this;
		}
		
		/**
		 * Limits the number of returned results to the specified quantity. (Optional).
		 * 
		 * @param limit Result limit.
		 * @return Builder instance.
		 */
		public GetBuilder limit(int limit) {
			this.parameter(PARAM_LIMIT, limit);
			return this;
		}
		
		/**
		 * Offset for listing. (Optional)
		 * 
		 * @param offset Offset amount.
		 * @return Builder instance.
		 */
		public GetBuilder offset(int offset) {
			this.parameter(PARAM_OFFSET, offset);
			return this;
		}
		
		/**
		 * Limit results to actions generated from these checks. (Optional)
		 * 
		 * @param checkIds List of IDs.
		 * @return Builder instance.
		 */
		public GetBuilder checkIds(List<Integer> checkIds) {
			this.parameter(PARAM_CHECK_IDS, checkIds);
			return this;
		}
		
		/**
		 * Limit results to actions sent to these contacts. (Optional)
		 * 
		 * @param contactIds List of IDs.
		 * @return Builder instance.
		 */
		public GetBuilder contactIds(List<Integer> contactIds) {
			this.parameter(PARAM_CONTACT_IDS, contactIds);
			return this;
		}
		
		/**
		 * Limit results to actions with these statuses. (Optional)
		 * 
		 * @param status Status to limit with.
		 * @return Builder instance.
		 */
		public GetBuilder status(AlertStatus status) {
			this.parameter(PARAM_STATUS, status);
			return this;
		}
		
		/**
		 * Limit results to actions with these mediums. (Optional)
		 * 
		 * @param via Via to limit with.
		 * @return Builder instance.
		 */
		public GetBuilder via(AlertVia via) {
			this.parameter(PARAM_VIA, via);
			return this;
		}
	}
}
