<xsl:stylesheet version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:param name="rulebook" as="xs:string" select="'CBPR+'"/>
  <xsl:template match="/">
    <pacs.009>
      <xsl:text>MT202 to pacs.009 transformation for </xsl:text>
      <xsl:value-of select="$rulebook"/>
    </pacs.009>
  </xsl:template>
</xsl:stylesheet>
