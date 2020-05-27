<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<body>
				<h2>Photos of the films</h2>
				<xsl:for-each select="movies/movie">

						<p><xsl:value-of select="title"/></p>
						<img>
							<xsl:attribute name="src">
								<xsl:value-of select="image-URL"/>
							</xsl:attribute>
						</img>
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>