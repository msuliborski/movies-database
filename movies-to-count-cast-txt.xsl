<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text" indent="yes"/>
	<xsl:template match="/">
Movies with cast count:
		<xsl:for-each select="/movies/movie">
- <xsl:value-of select="title"/> (<xsl:for-each select="cast">
					<xsl:value-of select="count(actor)"/>
				</xsl:for-each>)
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>