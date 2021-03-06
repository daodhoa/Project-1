USE [CayLamRoi]
GO
/****** Object:  Table [dbo].[BienLai]    Script Date: 29/11/2017 2:56:26 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BienLai](
	[MaBienLai] [int] IDENTITY(1000,1) NOT NULL,
	[MaGiaoDich] [char](10) NULL,
	[SoTienGD] [money] NULL,
	[SoTK] [bigint] NULL,
	[SoTKNhan] [bigint] NULL,
	[ThoiGian] [varchar](50) NULL,
 CONSTRAINT [PK__BienLai__3817DC5497E8F145] PRIMARY KEY CLUSTERED 
(
	[MaBienLai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[GiaoDich]    Script Date: 29/11/2017 2:56:26 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[GiaoDich](
	[MaGiaoDich] [char](10) NOT NULL,
	[LoaiGiaoDich] [nvarchar](20) NULL,
 CONSTRAINT [PK__GiaoDich__0A2A24EB9ACA9F7C] PRIMARY KEY CLUSTERED 
(
	[MaGiaoDich] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 29/11/2017 2:56:26 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[CMND] [varchar](9) NOT NULL,
	[HoTen] [nvarchar](30) NOT NULL,
	[NgaySinh] [date] NULL,
	[Email] [varchar](30) NULL,
	[DiaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK__KhachHan__F67C8D0A6505A0BF] PRIMARY KEY CLUSTERED 
(
	[CMND] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TKKhachHang]    Script Date: 29/11/2017 2:56:26 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TKKhachHang](
	[SoTK] [bigint] IDENTITY(1000000000000,1) NOT NULL,
	[CMND] [varchar](9) NULL,
	[NgayTao] [date] NULL,
	[MatKhau] [varchar](32) NOT NULL,
	[SoDu] [money] NULL,
 CONSTRAINT [PK__TKKhachH__BC3C8AF3DA3166BF] PRIMARY KEY CLUSTERED 
(
	[SoTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TheNap]    Script Date: 29/11/2017 2:56:26 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TheNap](
	[MaThe] [varchar](10) NOT NULL,
	[SoTien] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaThe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[BienLai] ON 

INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1000, N'#2        ', 2000000.0000, 1000000000000, NULL, N'Th 5 thg 11 16 21:52:34 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1001, N'#1        ', NULL, 1000000000000, NULL, N'Th 5 thg 11 16 22:10:03 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1002, N'#4        ', 100000.0000, 1000000000000, NULL, N'Th 5 thg 11 16 22:28:34 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1003, N'#4        ', 150000.0000, 1000000000000, NULL, N'Th 5 thg 11 16 22:29:18 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1004, N'#4        ', 100000.0000, 1000000000000, NULL, N'Th 6 thg 11 17 16:34:04 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1005, N'#4        ', 100000.0000, 1000000000000, NULL, N'Th 6 thg 11 17 16:38:24 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1006, N'#4        ', 100000.0000, 1000000000000, NULL, N'Th 6 thg 11 17 16:40:08 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1007, N'#4        ', 100000.0000, 1000000000000, NULL, N'Th 6 thg 11 17 16:46:02 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1008, N'#3        ', 100000.0000, 1000000000000, 1000000000001, N'Th 6 thg 11 17 17:29:45 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1009, N'#3        ', 100000.0000, 1000000000000, 1000000000001, N'Th 6 thg 11 17 17:35:57 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1010, N'#3        ', 1.0000, 1000000000000, 1000000000001, N'Th 6 thg 11 17 20:44:30 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1011, N'#3        ', 100000.0000, 1000000000000, 1000000000001, N'Th 6 thg 11 17 20:55:35 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1012, N'#4        ', 100000.0000, 1000000000000, NULL, N'Th 6 thg 11 17 20:56:41 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1013, N'#2        ', 500000.0000, 1000000000000, NULL, N'Th 6 thg 11 17 21:26:14 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1014, N'#2        ', 1000000.0000, 1000000000000, NULL, N'Th 6 thg 11 17 21:35:56 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1015, N'#3        ', 100000.0000, 1000000000000, 1000000000002, N'Th 3 thg 11 21 21:58:38 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1016, N'#3        ', 10000000.0000, 1000000000000, 1000000000003, N'Th 3 thg 11 21 22:00:49 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1017, N'#1        ', NULL, 1000000000000, NULL, N'Th 3 thg 11 21 22:04:21 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1018, N'#1        ', NULL, 1000000000000, NULL, N'Th 3 thg 11 21 22:04:21 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1019, N'#1        ', NULL, 1000000000000, NULL, N'Th 3 thg 11 21 22:04:21 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1020, N'#1        ', NULL, 1000000000000, NULL, N'Th 3 thg 11 21 22:04:52 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1021, N'#3        ', 11000.0000, 1000000000000, 1000000000001, N'Th 3 thg 11 21 22:04:55 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1022, N'#1        ', NULL, 1000000000000, NULL, N'Th 3 thg 11 21 22:05:46 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1023, N'#1        ', NULL, 1000000000000, NULL, N'Th 3 thg 11 21 22:06:03 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1024, N'#4        ', 100000.0000, 1000000000000, NULL, N'Th 3 thg 11 21 22:06:13 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (1025, N'#1        ', NULL, 1000000000000, NULL, N'Th 3 thg 11 21 22:06:24 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (2015, N'#2        ', 2000000.0000, 1000000000013, NULL, N'Th 4 thg 11 29 14:18:33 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (2016, N'#2        ', 5000000.0000, 1000000000013, NULL, N'Th 4 thg 11 29 14:19:29 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (2017, N'#1        ', NULL, 1000000000013, NULL, N'Th 4 thg 11 29 14:21:38 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (2018, N'#1        ', NULL, 1000000000013, NULL, N'Th 4 thg 11 29 14:21:38 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (2019, N'#3        ', 500000.0000, 1000000000013, 1000000000001, N'Th 4 thg 11 29 14:26:34 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (2020, N'#1        ', NULL, 1000000000013, NULL, N'Th 4 thg 11 29 14:29:44 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (2021, N'#4        ', 1000000.0000, 1000000000013, NULL, N'Th 4 thg 11 29 14:30:28 ICT 2017')
INSERT [dbo].[BienLai] ([MaBienLai], [MaGiaoDich], [SoTienGD], [SoTK], [SoTKNhan], [ThoiGian]) VALUES (2022, N'#4        ', 550000.0000, 1000000000013, NULL, N'Th 4 thg 11 29 14:31:26 ICT 2017')
SET IDENTITY_INSERT [dbo].[BienLai] OFF
INSERT [dbo].[GiaoDich] ([MaGiaoDich], [LoaiGiaoDich]) VALUES (N'#1        ', N'Vấn tin')
INSERT [dbo].[GiaoDich] ([MaGiaoDich], [LoaiGiaoDich]) VALUES (N'#2        ', N'Nạp tiền')
INSERT [dbo].[GiaoDich] ([MaGiaoDich], [LoaiGiaoDich]) VALUES (N'#3        ', N'Chuyển tiền')
INSERT [dbo].[GiaoDich] ([MaGiaoDich], [LoaiGiaoDich]) VALUES (N'#4        ', N'Rút tiền')
INSERT [dbo].[KhachHang] ([CMND], [HoTen], [NgaySinh], [Email], [DiaChi]) VALUES (N'123456241', N'Nguyen Minh B', CAST(N'1995-04-12' AS Date), N'hanoi@gmail.com', N'Hà nội')
INSERT [dbo].[KhachHang] ([CMND], [HoTen], [NgaySinh], [Email], [DiaChi]) VALUES (N'123456789', N'Dao duy hoa', CAST(N'1997-07-12' AS Date), N'abc@gmail.com', N'Nam dinh')
INSERT [dbo].[KhachHang] ([CMND], [HoTen], [NgaySinh], [Email], [DiaChi]) VALUES (N'123877664', N'Tran Dinh Van', CAST(N'1993-03-05' AS Date), N'adf@gmail.com', N'Nam Định')
INSERT [dbo].[KhachHang] ([CMND], [HoTen], [NgaySinh], [Email], [DiaChi]) VALUES (N'163435300', N'Đào Duy Hòa', CAST(N'1997-07-12' AS Date), N'duyhoa.dao1207@gmail.com', N'Nam Định')
INSERT [dbo].[KhachHang] ([CMND], [HoTen], [NgaySinh], [Email], [DiaChi]) VALUES (N'163435333', N'Nguyễn Văn A', CAST(N'1994-07-04' AS Date), N'nguyenvana@gmail.com', N'Nam Định')
INSERT [dbo].[KhachHang] ([CMND], [HoTen], [NgaySinh], [Email], [DiaChi]) VALUES (N'163435397', N'admin', CAST(N'1997-07-12' AS Date), N'duyhoa.dao1207@gmail.com', N'Hà Nội')
INSERT [dbo].[KhachHang] ([CMND], [HoTen], [NgaySinh], [Email], [DiaChi]) VALUES (N'163435399', N'Đào Duy Hòa', CAST(N'1997-07-12' AS Date), N'duyhoa.dao1207@gmail.com', N'Nam Định')
SET IDENTITY_INSERT [dbo].[TKKhachHang] ON 

INSERT [dbo].[TKKhachHang] ([SoTK], [CMND], [NgayTao], [MatKhau], [SoDu]) VALUES (1000000000000, N'163435397', CAST(N'2017-11-15' AS Date), N'81dc9bdb52d04dc20036dbd8313ed055', 2038999.0000)
INSERT [dbo].[TKKhachHang] ([SoTK], [CMND], [NgayTao], [MatKhau], [SoDu]) VALUES (1000000000001, N'163435399', CAST(N'2017-11-16' AS Date), N'202cb962ac59075b964b07152d234b70', 961001.0000)
INSERT [dbo].[TKKhachHang] ([SoTK], [CMND], [NgayTao], [MatKhau], [SoDu]) VALUES (1000000000002, N'163435333', CAST(N'2017-11-16' AS Date), N'202cb962ac59075b964b07152d234b70', 150000.0000)
INSERT [dbo].[TKKhachHang] ([SoTK], [CMND], [NgayTao], [MatKhau], [SoDu]) VALUES (1000000000003, N'123456789', CAST(N'2017-11-19' AS Date), N'202cb962ac59075b964b07152d234b70', 10050000.0000)
INSERT [dbo].[TKKhachHang] ([SoTK], [CMND], [NgayTao], [MatKhau], [SoDu]) VALUES (1000000000007, N'123877664', CAST(N'2017-11-19' AS Date), N'202cb962ac59075b964b07152d234b70', 50000.0000)
INSERT [dbo].[TKKhachHang] ([SoTK], [CMND], [NgayTao], [MatKhau], [SoDu]) VALUES (1000000000008, N'123456241', CAST(N'2017-11-19' AS Date), N'202cb962ac59075b964b07152d234b70', 50000.0000)
INSERT [dbo].[TKKhachHang] ([SoTK], [CMND], [NgayTao], [MatKhau], [SoDu]) VALUES (1000000000013, N'163435300', CAST(N'2017-11-29' AS Date), N'202cb962ac59075b964b07152d234b70', 5000000.0000)
SET IDENTITY_INSERT [dbo].[TKKhachHang] OFF
INSERT [dbo].[TheNap] ([MaThe], [SoTien]) VALUES (N'0123456789', 5000000.0000)
INSERT [dbo].[TheNap] ([MaThe], [SoTien]) VALUES (N'1234512345', 2000000.0000)
INSERT [dbo].[TheNap] ([MaThe], [SoTien]) VALUES (N'2456135700', 1000000.0000)
INSERT [dbo].[TheNap] ([MaThe], [SoTien]) VALUES (N'2911201754', 2000000.0000)
ALTER TABLE [dbo].[BienLai]  WITH CHECK ADD  CONSTRAINT [FK__BienLai__MaGiaoD__182C9B23] FOREIGN KEY([MaGiaoDich])
REFERENCES [dbo].[GiaoDich] ([MaGiaoDich])
GO
ALTER TABLE [dbo].[BienLai] CHECK CONSTRAINT [FK__BienLai__MaGiaoD__182C9B23]
GO
ALTER TABLE [dbo].[BienLai]  WITH CHECK ADD  CONSTRAINT [FK__BienLai__SoTK__173876EA] FOREIGN KEY([SoTK])
REFERENCES [dbo].[TKKhachHang] ([SoTK])
GO
ALTER TABLE [dbo].[BienLai] CHECK CONSTRAINT [FK__BienLai__SoTK__173876EA]
GO
ALTER TABLE [dbo].[TKKhachHang]  WITH CHECK ADD  CONSTRAINT [FK__TKKhachHan__CMND__1273C1CD] FOREIGN KEY([CMND])
REFERENCES [dbo].[KhachHang] ([CMND])
GO
ALTER TABLE [dbo].[TKKhachHang] CHECK CONSTRAINT [FK__TKKhachHan__CMND__1273C1CD]
GO
