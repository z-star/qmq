package qunar.tc.qmq.meta.spi.check;

import qunar.tc.qmq.protocol.consumer.MetaInfoRequest;

/**
 * The interface Pre check.
 * @description：
 * @author  ：zhixin.zhang
 * @date  ：Created in 6:52 PM 2022/11/4
 */
public interface PreCheck {

	/**
	 * Check boolean.
	 *
	 * @param request the request
	 * @return the boolean
	 */
	boolean check( final MetaInfoRequest request);
}
