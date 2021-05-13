create database if not exists database_design_exercise1;
use database_design_exercise1;
create table phieu_xuat (
`id_phieu_xuat` int not null primary key,
`ngay_xuat` date);

create table phieu_nhap (
`id_phieu_nhap` int not null primary key,
`ngay_nhap` date);

create table nha_cung_cap (
`id_nha_cung_cap` int not null primary key,
`ten_nha_cung_cap` varchar(45),
`dia_chi_nha_cung_cap` varchar(45),
`sdt_nha_cung_cap` varchar(45));

create table don_dat_hang (
`id_dat_hang` int not null primary key,
`id_nha_cung_cap` int not null,
`ngay_dat_hang` date,
foreign key (`id_nha_cung_cap`) references nha_cung_cap(`id_nha_cung_cap`));


create table vat_tu (
`id_vat_tu` int not null primary key,
`ten_vat_tu` varchar(45));

create table chi_tiet_phieu_xuat (
`id_phieu_xuat` int not null,
`id_vat_tu` int not null,
`don_gia_xuat` varchar(45),
`so_luong_xuat` int,
primary key (`id_phieu_xuat`,`id_vat_tu`),
foreign key (`id_phieu_xuat`) references phieu_xuat (`id_phieu_xuat`),
foreign key (`id_vat_tu`) references vat_tu (`id_vat_tu`));

create table chi_tiet_phieu_nhap (
`id_phieu_nhap` int not null,
`id_vat_tu` int not null,
`don_gia_nhap` varchar(45),
`so_luong_nhap` int,
primary key (`id_phieu_nhap`,`id_vat_tu`),
foreign key (`id_phieu_nhap`) references phieu_nhap (`id_phieu_nhap`),
foreign key (`id_vat_tu`) references vat_tu (`id_vat_tu`));

create table chi_tiet_don_dat_hang (
`id_dat_hang` int not null,
`id_vat_tu` int not null,
primary key (`id_dat_hang`,`id_vat_tu`),
foreign key (`id_dat_hang`) references don_dat_hang (`id_dat_hang`),
foreign key (`id_vat_tu`) references vat_tu (`id_vat_tu`));
