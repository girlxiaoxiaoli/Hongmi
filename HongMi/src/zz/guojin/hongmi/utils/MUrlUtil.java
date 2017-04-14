package zz.guojin.hongmi.utils;

/**
 * URL
 */
public class MUrlUtil {
	// www.jinyuejinrong68.com
	public static final String BASE_URL = "http://hm.guojin123.net/";
	// 测试登录URL
	public static final String LOGIN_URL = "app/login/login";
	// 首页
	public static final String HOME = "App/help/profile";
	// 短信验证码（找回密码）
	public static final String SMS_PWD = "app/login/check_phone1";
	// 忘记密码
	public static final String FORGET = "app/login/password_update";
	// 注册
	public static final String REGIST = "app/login/register";
	// 新闻 http://192.168.1.22/App/help/news
	public static final String NEWS_URL = "App/help/news";
	// 个人资料
	public static final String PERSONAL_DATA = "App/help/promember";
	// 修改登陆密码
	public static final String CHANGE_LOGIN_PWD = "App/apply/revamp";
	// 修改二级密码
	public static final String CHANGE_SECOND_PWD = "App/apply/revamp1";
	// 留言板
	public static final String TOUCH = "App/apply/lxwmcl";
	// 激活码数量
	public static final String ACTIVE_CODE = "App/apply/pinnum";
	// 激活码互转 exchange
	public static final String EXCHANGE_URL = "App/apply/activa";
	// 激活码转入记录
	public static final String EXCHANGE_INCOMING = "App/apply/pin_list1";

	// 激活码转出记录
	public static final String EXCHANGE_OUTING = "App/apply/pin_list";
	// 反馈回复
	public static final String REPLY = "App/apply/lyhf";

	// 打米提供额度
	public static final String LIMIT_OFFER = "App/apply/acce";
	// 打米提交
	public static final String CONFIRM_OFFER = "App/apply/acceptcl";
	// 收米：
	public static final String ACCEPT_URL = "App/apply/providecl";
	// 打米记录排单信息
	public static final String GET_PD = "App/help/js_order";
	// 打米记录 排单信息
	public static final String GIVE_PD = "App/help/tg_order";
	// 打米匹配信息
	public static final String GIVE_PP = "App/help/js_order1";
	// 打米匹配信息 App/help/tg_list
	public static final String GET_PP = "App/help/tg_order1";
	// 打米，详细信息
	public static final String SHE_DETAILS = "App/help/detail_tg";
	// 打米 打款接口
	public static final String SHE_TO = "App/deal/tg_play";
	// 收米 详细信息
	public static final String DE_DET = "App/help/detail_js";
	// 收米 收款接口
	public static final String DE_TO = "App/deal/js_play";
	// 商城
	public static final String SHOP = "App/shop/index";
	// 购买
	public static final String PAY = "App/shop/addOrderform";
	// 奖金总额
	public static final String HELP_WALLET = "App/help/groom";
	// 实施奖金
	public static final String INTEREST = "App/help/interest";
	// 二维码
	public static final String LIANJIE = "app/help/erwm";
	// 清算本金
	public static final String CLEAR_CAPITAL = "app/apply/tover";
	// 解冻记录
	public static final String UNFREEZE = "app/help/ddcold";
	// 管理账号
	public static final String ADMIN_ACCOUNT = "App/login/tc";
	// 实时奖金 提现按钮
	public static final String CONFIRM_MONEY = "App/deal/tgbz_tx_cl";
	// 团队管理
	public static final String SHOU_PASS_URL = "App/help/censor";

	// 大转盘奖品等级 App/turn/index
	public static final String AWARD = "App/turn/index";
	// 大转盘请求奖项接口 Awards
	public static final String AWARDS = "App/turn/get_v";
	// 抽奖记录
	public static final String AWARD_RECORD = "app/turn/turn_list";

	/* 数据对接到此 */

	// 财务管理 奖金纪录
	public static final String RECOMMEND_MONEY = "App/help/record";

	// 抢单币数量
	public static final String QIANG_CODE = "App/apply/qiangnum";
	// 抢单币转让
	public static final String EXCHNAGE_QIANG_CODE = "App/apply/qactiva";
	// 抢单币转出记录
	public static final String QIANG_INCOMING = "App/apply/qiang_list";

	// 团队管理
	public static final String RECOMMEND_PERSON = "App/help/recom1";
	// 测试，显示推荐人 和 激活码
	public static final String SHOW_URL = "App/help/reg";
	// 测试，注册会员。
	public static final String VIP_URL = "App/apply/regadd";
	// 审核通过
	public static final String PASS_URL = "App/apply/censorcl";
	// 抢单中心 列表
	public static final String QIANG_URL = "App/apply/accept";
	// 抢单
	public static final String QIANG = "App/apply/acceptcl";
	// 抢单类型
	public static final String QIANG_ID = "App/apply/acce";

	// 测试 钱包
	public static final String MONEY_URL = "App/help/money";
	// 测试 任务提交 refer
	public static final String REFER_URL = "App/apply/taskcl";

	// 测试 拍单币互转
	public static final String PDBHUZ_URL = "App/apply/pdb_zr";

	// 测试 个人页面信息http://192.168.1.22/App/help/profile
	public static final String PERSONAL_URL = "App/help/profile";
	// 修改个人资料
	// 我的用户群 提供帮助http://192.168.1.22/App/help/groupt
	public static final String OFFER_HELP_GROUP = "App/help/groupt";

	// 我的用户群，接受帮助
	public static final String ACCEPT_HELP_GROUP = "App/help/groupj";

	// 提供帮助钱包
	public static final String OFFER_HELP_PURSE = "App/help/interest";

	// 提现 接口 /App/apply/jjtx
	public static final String TX_CODE = "App/apply/jjtx";

	public static final String base_url = MUrlUtil.BASE_URL.substring(0,
			MUrlUtil.BASE_URL.length() - 1);

}
