package qunar.tc.qmq.meta.spi.check;

import java.util.List;
import java.util.ServiceLoader;

import com.google.common.collect.Lists;
import qunar.tc.qmq.protocol.consumer.MetaInfoRequest;

/**
 * @description：
 * @author     ：zhixin.zhang
 * @date       ：Created in 下午6:07 2022/11/04
 */
public class PreCheckFactory {

	private static List<PreCheck> checks = Lists.newArrayList();

	static {
		ServiceLoader<PreCheck> services = ServiceLoader.load(PreCheck.class);
		for (PreCheck preCheck : services) {
			checks.add(preCheck);
		}
	}

	public static boolean check(final MetaInfoRequest request) {
		if (checks.size() == 0) {
			return true;
		}
		for (PreCheck preCheck : checks) {
			if (!preCheck.check(request)) {
				return false;
			}
		}
		return true;
	}

	;

	public static List<PreCheck> getChecks() {
		return checks;
	}
}
