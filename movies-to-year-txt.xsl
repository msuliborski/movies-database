<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text" indent="no"/>
	<xsl:template match="/">
Movies sorted by year:
		<xsl:for-each select="/movies/movie">
			<xsl:sort select="year"/>
			<xsl:if test="year!=0">
- <xsl:value-of select="title"/> (<xsl:value-of select="year"/>)
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>