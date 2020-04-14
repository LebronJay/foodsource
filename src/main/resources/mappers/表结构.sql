-- foodsource	3306	root root
-- 用户表
create table if not EXISTS db_user(
  user_id varchar(32)  not null comment '用户编号',
  login_name varchar(32) not null comment '登录名称',
  passwd varchar(160) not null comment '密码',
  nick_name varchar(32) null comment '昵称',
  tel varchar(32) comment '电话号码',
  email varchar(32) comment '邮箱',
  gender varchar(32) comment '性别',
  head_pic varchar(32) null comment '头像',
  birth_date datetime null comment '出生日期',
  introduction varchar(32) null comment '简介',
  location_addr varchar(100) null comment '所在地',
  graduate_school varchar(256) null comment '毕业院校',
  permission char(1) default '0' not null comment '权限状态；0:用户;1:管理员;2:超级管理员',
  state char(1) default '0' not null comment '状态；0:有效;1:无效',
  input_date datetime null comment '录入时间',
  last_mod_date datetime null comment '修改时间',

  constraint pk_db_user primary key (user_id)
) comment='用户';

-- 菜品词条表
create table if not EXISTS db_food_entry(
  food_entry_id varchar(32)  not null comment '词条编号',
  entry_name varchar(32) not null comment '词条名称',
  entry_english_name varchar(32) comment '词条英文名',
  entry_tag varchar(256) null comment '词条标签',
  entry_taste varchar(100) null comment '口味',
  entry_cuisine varchar(100) not null comment '菜系',
  main_ingredients varchar(1000) not null comment '主要食材',
  make_way varchar(1000) null comment '制作方式',
  common_area varchar(100) null comment '地域',
  entry_introduction varchar(1000) null comment '简介',
  entry_history varchar(1000) null comment '历史文化',
  entry_content text null comment '内容',
#   entry_browse_count int default 0 not null comment '词条浏览数',
#   edit_count int default 0 not null comment '编辑次数',
  entry_img1 varchar(256) null comment '图片1',
  entry_img2 varchar(256) null comment '图片2',
  entry_img3 varchar(256) null comment '图片3',
  entry_img4 varchar(256) null comment '图片4',
  entry_img5 varchar(256) null comment '图片5',
  state char(1) default '0' not null comment '状态；0:有效;1:无效',
  o_id_input varchar(32) null comment '录入人',
  input_date datetime null comment '录入时间',
  o_id_modify varchar(32) null comment '修改人',
  last_mod_date datetime null comment '修改时间',
  entry_state char(1) default '0' not null comment '词条状态；0:保存;1:提交',

  constraint pk_db_food_entry primary key (food_entry_id)
) comment='菜品词条';

-- 文章表
create table if not EXISTS db_article(
  article_id varchar(32)  not null comment '文章编号',
  article_title varchar(32) not null comment '文章标题',
  article_tag varchar(256) null comment '文章标签',
  article_content text null comment '内容',
  o_id_user varchar(32) not null comment '作者',
  article_state char(1) default '0' not null comment '文章状态；0:保存;1:发表',
  publish_date datetime null comment '发表时间',
  article_browse_count int default 0 not null comment '文章浏览数',
  article_img1 varchar(256) null comment '图片1',
  article_img2 varchar(256) null comment '图片2',
  article_img3 varchar(256) null comment '图片3',
  article_img4 varchar(256) null comment '图片4',
  article_img5 varchar(256) null comment '图片5',
  state char(1) default '0' not null comment '状态；0:有效;1:无效',
  input_date datetime null comment '录入时间',
  last_mod_date datetime null comment '修改时间',

  constraint pk_db_article primary key (article_id)
) comment='文章';

-- 评论表
create table if not EXISTS db_comment(
  comment_id varchar(32)  not null comment '评论编号',
  parent_id varchar(32) not null comment '评论对象编号',
  comment_content varchar(500) null comment '内容',
  o_id_user varchar(32) not null comment '用户',
  state char(1) default '0' not null comment '状态；0:有效;1:无效',
  input_date datetime null comment '录入时间',
  last_mod_date datetime null comment '修改时间',

  constraint pk_db_comment primary key (comment_id)
) comment='评论';
create index ix_db_comment_id on db_comment(parent_id);



-- 热搜表
create table if not EXISTS op_hot_search(
  hot_search_id varchar(32)  not null comment '热搜编号',
  search_id varchar(32)  not null comment '搜索编号',
  search_type char(1) not null comment '搜索类型；0:词条;1:文章',
  search_date datetime null comment '搜索时间',
  o_id_user varchar(32) not null comment '用户',
  state char(1) default '0' not null comment '状态；0:有效;1:无效',

  constraint pk_op_hot_search primary key (hot_search_id)
) comment='热搜表';

-- 词条编辑记录表
create table if not EXISTS op_entry_edit_record(
  entry_edit_record_id varchar(32)  not null comment '编辑记录编号',
  food_entry_id varchar(32)  not null comment '词条编号',
  entry_name varchar(32) not null comment '词条名称',
  entry_english_name varchar(32) comment '词条英文名',
  entry_tag varchar(256) null comment '词条标签',
  entry_taste varchar(100) null comment '口味',
  entry_cuisine varchar(100) not null comment '菜系',
  main_ingredients varchar(1000) not null comment '主要食材',
  make_way varchar(1000) null comment '制作方式',
  common_area varchar(100) null comment '地域',
  entry_introduction varchar(1000) null comment '简介',
  entry_history varchar(1000) null comment '历史文化',
  entry_content text null comment '内容',
  entry_img1 varchar(256) null comment '图片1',
  entry_img2 varchar(256) null comment '图片2',
  entry_img3 varchar(256) null comment '图片3',
  entry_img4 varchar(256) null comment '图片4',
  entry_img5 varchar(256) null comment '图片5',
  edit_date datetime null comment '编辑时间',
  o_id_input varchar(32) not null comment '用户',
  entry_state char(1) default '0' not null comment '词条状态；0:保存;1:提交',
  state char(1) default '0' not null comment '状态；0:有效;1:无效',

  constraint pk_op_hot_search primary key (entry_edit_record_id)
) comment='词条编辑记录表';
alter table op_entry_edit_record add constraint fk_op_entry_edit_record foreign key(food_entry_id)
references db_food_entry (food_entry_id)
on update cascade
on delete cascade;

create index ix_op_entry_edit_record_id on op_entry_edit_record(food_entry_id);

-- 词条点赞收藏表
create table if not EXISTS op_entry_like_collect(
  food_entry_id varchar(32)  not null comment '词条编号',
  like_state char(1) default '0' not null comment '点赞；0:未点赞;1:点赞',
  like_date datetime null comment '点赞时间',
  collect_state char(1) default '0' not null comment '收藏；0:未收藏;1:收藏',
  collect_date datetime null comment '收藏时间',
  o_id_user varchar(32) not null comment '用户',
  state char(1) default '0' not null comment '状态；0:有效;1:无效',

  constraint pk_op_entry_like_collect primary key (food_entry_id,o_id_user)
) comment='词条点赞收藏表';
alter table op_entry_like_collect add constraint fk_op_entry_like_collect_food_entry_id foreign key(food_entry_id)
references db_food_entry (food_entry_id)
on update cascade
on delete cascade;
alter table op_entry_like_collect add constraint fk_op_entry_like_collect_o_id_user foreign key(o_id_user)
references db_user (user_id)
on update cascade
on delete cascade;

-- 文章点赞收藏表
create table if not EXISTS op_article_like_collect(
  article_id varchar(32)  not null comment '文章编号',
  like_state char(1) default '0' not null comment '点赞；0:未点赞;1:点赞',
  like_date datetime null comment '点赞时间',
  collect_state char(1) default '0' not null comment '收藏；0:未收藏;1:收藏',
  collect_date datetime null comment '收藏时间',
  o_id_user varchar(32) not null comment '用户',
  state char(1) default '0' not null comment '状态；0:有效;1:无效',

  constraint pk_op_article_like_collect primary key (article_id,o_id_user)
) comment='文章点赞收藏表';
alter table op_article_like_collect add constraint fk_op_article_like_collect_article_id foreign key(article_id)
references db_article (article_id)
on update cascade
on delete cascade;
alter table op_article_like_collect add constraint fk_op_article_like_collect_o_id_user foreign key(o_id_user)
references db_user (user_id)
on update cascade
on delete cascade;

-- 评论点赞收藏表
create table if not EXISTS op_comment_like_collect(
  comment_id varchar(32)  not null comment '评论编号',
  like_state char(1) default '0' not null comment '点赞；0:未点赞;1:点赞',
  like_date datetime null comment '点赞时间',
  collect_state char(1) default '0' not null comment '收藏；0:未收藏;1:收藏',
  collect_date datetime null comment '收藏时间',
  o_id_user varchar(32) not null comment '用户',
  state char(1) default '0' not null comment '状态；0:有效;1:无效',

  constraint pk_op_comment_like_collect primary key (comment_id,o_id_user)
) comment='评论点赞收藏表';
alter table op_comment_like_collect add constraint fk_op_comment_like_collect_comment_id foreign key(comment_id)
references db_comment (comment_id)
on update cascade
on delete cascade;
alter table op_comment_like_collect add constraint fk_op_comment_like_collect_o_id_user foreign key(o_id_user)
references db_user (user_id)
on update cascade
on delete cascade;
