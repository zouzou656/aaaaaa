<xsl:stylesheet version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:param name="rulebook" as="xs:string" select="'CBPR+'"/>
  <xsl:template match="/">
    <mt103>
      <xsl:text>pacs.008 to MT103 transformation for </xsl:text>
      <xsl:value-of select="$rulebook"/>
    </mt103>
  </xsl:template>
</xsl:stylesheet>
