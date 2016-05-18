Date date = new Date();
Timestamp timeStamp = new Timestamp(date.getTime());
clientinfo.setClientinfoAddtime(timeStamp);
这样放入数据库的就是“yyyy-mm-dd hh:mm:ss”格式的数据


在 客服 审核之前，任何合同都可以自行修改。
权限解答：
1.权限 当admins表内所有权限为0的时候，账户是封停状态的。
2.浏览权 0=不可浏览 1=可浏览自己 2=浏览全部
3.录入权 0=不可录入 1=可录入自己 2=可选择要录入的人员(权限最大化，可修改所有选项)
4.审核权0=不可审核  1=可审核