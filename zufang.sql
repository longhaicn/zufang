CREATE TABLE [dbo].[fangwu_info](
	[f_id] [int] IDENTITY(1,1) NOT NULL,
	[f_date] [varchar](50) NULL,
	[f_mess] [varchar](50) NULL,
	[f_money] [varchar](50) NULL,
	[f_people] [varchar](50) NULL,
	[f_shi] [int] NULL,
	[f_tel] [varchar](50) NULL,
	[f_ting] [int] NULL,
	[f_title] [varchar](50) NULL,
	[h_id] [int] NULL,
	[u_id] [int] NULL
) ON [PRIMARY]

CREATE TABLE [dbo].[house_info](
	[h_id] [int] IDENTITY(1,1) NOT NULL,
	[h_name] [varchar](50) NULL
) ON [PRIMARY]

CREATE TABLE [dbo].[user_info](
	[u_id] [int] IDENTITY(1,1) NOT NULL,
	[u_name] [varchar](50) NULL,
	[u_pass] [varchar](50) NULL
) ON [PRIMARY]

INSERT INTO [zufang].[dbo].[house_info]([h_name])VALUES('House')
INSERT INTO [zufang].[dbo].[house_info]([h_name])VALUES('Villa')

