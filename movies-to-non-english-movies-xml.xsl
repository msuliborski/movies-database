<xsl:stylesheet
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		version="1.0">

	<xsl:strip-space elements="*"/>
	<xsl:output indent="yes"/>

	<xsl:template match="/">
		<movies>
			<xsl:for-each select="movies/movie[original-language!='English' and original-language!='']">
				<movie>
					<title>
						<xsl:value-of select="title"/>
					</title>
					<year>
						<xsl:value-of select="year"/>
					</year>
					<country>
						<xsl:value-of select="country"/>
					</country>
					<director>
						<xsl:value-of select="director"/>
					</director>
					<original-language>
						<xsl:value-of select="original-language"/>
					</original-language>
				</movie>
			</xsl:for-each>
		</movies>
	</xsl:template>
</xsl:stylesheet>