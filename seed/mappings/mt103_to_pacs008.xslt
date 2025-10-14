<xsl:stylesheet version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:param name="rulebook" as="xs:string" select="'CBPR+'"/>
  <xsl:template match="/">
    <pacs.008>
      <xsl:text>MT103 to pacs.008 transformation for </xsl:text>
      <xsl:value-of select="$rulebook"/>
    </pacs.008>
  </xsl:template>
</xsl:stylesheet>
