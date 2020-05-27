<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" indent="no"/>
	<xsl:template match="/">
Movies in United States:
		<xsl:for-each select="/movies/movie">
			<xsl:if test="country='United States'">
- <xsl:value-of select="title"/>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>