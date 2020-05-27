<xsl:stylesheet
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		version="1.0">

	<xsl:strip-space elements="*"/>
	<xsl:output indent="yes"/>

	<xsl:template match="/">
		<movies>
			<xsl:for-each select="movies/movie[director='Ridley Scott']">
				<movie>
					<title>
						<xsl:value-of select="title"/>
					</title>
				</movie>
			</xsl:for-each>
		</movies>
	</xsl:template>
</xsl:stylesheet>