select * from orders;
select * from order_detail;

GO
/****** Object:  StoredProcedure [dbo].[_lab7]    Script Date: 14/01/2022 13:02:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[_lab7]
@ano int, @marca char(5), @trimestre tinyint
AS
SELECT p.Producto,d.Fecha, SUM(dd.cantidad * dd.PrecUnit) as venta
FROM DOCUMENTO d INNER JOIN DETADOC dd on d.Documento = dd.Documento and d.TipoDoc = dd.TipoDoc INNER JOIN PRODUCTO p on dd.Producto = p.Producto
WHERE DATEPART(QQ, d.Fecha) = @trimestre AND YEAR(D.Fecha) = @ano AND d.Cliente IS NOT NULL AND dd.Producto = @marca
GROUP BY p.Producto,d.Fecha
ORDER BY SUM(dd.Cantidad * dd.PrecUnit) desc